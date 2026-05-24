@echo off
title Flight Booking Test Framework
color 0E
echo ========================================
echo    Flight Booking Test Automation
echo ========================================
echo.
echo Running Test Suite...
echo.
mvn clean test
echo.
echo ========================================
echo    Test Execution Completed!
echo    Check test-output folder for reports
echo ========================================
pause