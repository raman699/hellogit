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


