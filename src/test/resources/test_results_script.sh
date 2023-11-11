#!/usr/bin/bash

TEST_RESULTS_LOCATION="${1:-/home/runner/work/CucumberPagObjects/CucumberPagObjects/target/surefire-reports}"
TEST_RESULTS_STRING=$(cat "${TEST_RESULTS_LOCATION}/testng-results.xml" | grep "<testng-results")
echo "SKIPPED_TESTS=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $2}')"
echo "FAILED_TESTS=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $4}')"
echo "TOTAL_TESTS=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $6}')"
echo "PASSED_TESTS=$(echo ${TEST_RESULTS_STRING} | awk -F'"' '{print $8}')"