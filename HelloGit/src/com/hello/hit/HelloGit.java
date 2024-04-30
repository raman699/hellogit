package com.hello.hit;

public class HelloGit {

	public static void main(String[] args) {
		System.out.println("hello git");

	}

}#!/bin/bash

# Function to scan files for passwords
scan_for_passwords() {
    # Get list of staged files
    git diff --name-only --cached | while IFS= read -r file; do
        # Check if the file exists and is a regular file
        if [ -f "$file" ]; then
            # Use grep or any other tool to scan for passwords
            # Here, we're using grep to search for the word "password"
            if grep -q "password" "$file"; then
                echo "Potential password found in file: $file"
                # Additional actions can be added here, such as logging or removing the file
            fi
        fi
    done
}

# Main function
main() {
    echo "Scanning staged files for passwords..."
    scan_for_passwords
    echo "Password scanning completed."
}

# Execute main function
main


name: Regex Password Check

on:
  push:
    branches:
      - main  # Change to your default branch name if different

jobs:
  check_passwords:
    name: Check for Passwords
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2

      - name: Scan for passwords
        run: |
          # Use grep to search for potential passwords using a regex pattern
          grep -rnEi --include=*.{txt,md,conf,yml,yaml} '(password|pwd|pass)\s*[:=]' .

        # Note: Adjust the file extensions in --include=*.{...} to include relevant file types

        # Add additional steps here if needed, such as logging or further processing of matches

name: Regex Password Check

on:
  push:
    branches:
      - main  # Change to your default branch name if different

jobs:
  check_passwords:
    name: Check for Passwords
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2

      - name: Scan for passwords
        run: |
          # Use grep to search for potential passwords using a regex pattern
          find . -type f -regextype posix-extended -regex '.*\.(txt|md|conf|yml|yaml)' -exec grep -lEi '(password|pwd|pass)\s*[:=]' {} + || true

        # Note: Adjust the file extensions in the regex pattern to include relevant file types

        # Add additional steps here if needed, such as logging or further processing of matches
name: Regex Password Check

on:
  push:
    branches:
      - main  # Change to your default branch name if different

jobs:
  check_passwords:
    name: Check for Passwords
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2

      - name: Scan for passwords
        run: |
          # Use find to locate files based on a regex pattern and then grep to search for passwords
          find . -type f -regextype posix-extended -regex '.*\.(txt|md|conf|yml|yaml)' -exec grep -qEi '(password|pwd|pass)\s*[:=]' {} \; && { echo "Potential passwords found. Action failed."; exit 1; } || true

        # Note: Adjust the file extensions in the regex pattern to include relevant file types

        # Add additional steps here if needed, such as logging or further processing of matches
name: Regex Password Check

on:
  push:
    branches:
      - main  # Change to your default branch name if different

jobs:
  check_passwords:
    name: Check for Passwords
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2

      - name: Scan for passwords
        run: |
          # Use a shell script to search for passwords
          if find . -type f -regextype posix-extended -regex '.*\.(txt|md|conf|yml|yaml)' -exec grep -qEi '(password|pwd|pass)\s*[:=]' {} \;; then
            echo "Potential passwords found. Action failed."
            exit 1
          else
            echo "No potential passwords found. Action succeeded."
          fi

        # Note: Adjust the file extensions in the regex pattern to include relevant file types

        # Add additional steps here if needed, such as logging or further processing of matches

hhhSELECT t1.col1, t1.col2, t1.col3, t1.concat_col
FROM your_table t1
INNER JOIN your_table t2 ON t1.concat_col = t2.concat_col
WHERE t1.col1 != t2.col1
AND t1.col2 != t2.col2
AND t1.col3 != t2.col3;


gg
name: Java Unit Test Coverage

on:
  push:
    branches:
      - main

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v2

    - name: Set up JDK
      uses: actions/setup-java@v2
      with:
        java-version: '11'

    - name: Build with Maven
      run: mvn -B clean package

    - name: Run tests with JaCoCo coverage
      run: mvn -B jacoco:prepare-agent test jacoco:report

    - name: Upload coverage report
      uses: actions/upload-artifact@v2
      with:
        name: coverage
        path: target/site/jacoco/index.html

  <plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.7</version>
    <executions>
        <execution>
            <id>jacoco-initialize</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>jacoco-site</id>
            <phase>package</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>








