#!/usr/bin/bash

TEST_RESULTS_LOCATION="${1:-/home/runner/work/CucumberPagObjects/CucumberPagObjects/target/surefire-reports}"
TEST_RESULTS_STRING=$(cat "${TEST_RESULTS_LOCATION}/testng-results.xml" | grep "<testng-results")
echo "SKIPPED_TESTS=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $2}')"
echo "FAILED_TESTS=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $4}')"
echo "TOTAL_TESTS=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $6}')"
echo "PASSED_TESTS=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $8}')"

cat <<EOF | curl --data-binary @- ${PUSHGATEWAY_URL}/metrics/job/github_actions
github_actions_skipped_tests{action_id="${GITHUB_RUN_NUMBER}", commit="${GITHUB_SHA}", actor="${GITHUB_ACTOR}", branch="${GITHUB_REF}"} $(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $2}')
github_actions_failed_tests{action_id="${GITHUB_RUN_NUMBER}", commit="${GITHUB_SHA}", actor="${GITHUB_ACTOR}", branch="${GITHUB_REF}"} $(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $4}')
github_actions_total_tests{action_id="${GITHUB_RUN_NUMBER}", commit="${GITHUB_SHA}", actor="${GITHUB_ACTOR}", branch="${GITHUB_REF}"} $(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $6}')
github_actions_passed_tests{action_id="${GITHUB_RUN_NUMBER}", commit="${GITHUB_SHA}", actor="${GITHUB_ACTOR}", branch="${GITHUB_REF}"} $(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $8}')
EOF

echo " CucumberPagObjects.maventest.skipped=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $2}')" >> $BUILDEVENT_FILE
echo " CucumberPagObjects.maventest.failed=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $4}')" >> $BUILDEVENT_FILE
echo " CucumberPagObjects.maventest.total=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $6}')" >> $BUILDEVENT_FILE
echo " CucumberPagObjects.maventest.passed=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $8}')" >> $BUILDEVENT_FILE