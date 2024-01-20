# N-Gram Frequency Builder

## Overview
The N-Gram Frequency Builder is a Java application that analyzes text files in a specified directory. It processes the text, generating a mapping of n-grams and their frequencies, and exports the results to a CSV file. The application offers a straightforward command-line interface for users to set the directory, n-gram size, and output file.

## Features
- Parses text files in a specified directory.
- Builds a frequency table for each unique lowercase n-gram in the text files.
- Strips unwanted characters and whitespace during text processing.
- Outputs the n-gram frequency table to a CSV file.

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/your-username/ngram-frequency-builder.git
cd ngram-frequency-builder
```

### Run the Application
```bash
javac ie/atu/sw/Runner.java
java ie.atu.sw.Runner
```

### Follow the On-Screen Instructions
1. Specify the text file directory.
2. Choose the n-gram size (1 to 5).
3. Specify the output file name (CSV format).
4. Build N-Grams and view the results.

## Requirements
- Java Development Kit (JDK) installed (version 8 or higher).

## Directory Structure
- `ie/atu/sw`: Java package containing the source code.
- `README.md`: This file.
- `LICENSE`: The project's license.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

## License
This project is licensed under the MIT License.
