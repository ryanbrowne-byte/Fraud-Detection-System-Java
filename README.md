# 🛡️ AI-Powered Credit Card Fraud Detection System

This project is a Java-based Machine Learning application designed to identify fraudulent financial transactions with a high degree of accuracy (**99.98%**). Developed as an end-of-semester project for the Data Science and Analytics program at **UMaT**.

## 🚀 Overview
Traditional rule-based systems often miss subtle fraud patterns. This system utilizes the **J48 (C4.5) Decision Tree algorithm** to build an explainable model that classifies transactions based on complex feature relationships.

## 🛠️ Key Features
- **Machine Learning Integration:** Uses the Weka library for supervised learning.
- **Explainable AI:** Generates a visual Decision Tree flowchart to audit the AI's logic.
- **High Performance:** Successfully detected 36/38 fraud cases in the test sample.

## 📋 Prerequisites for Running
To run this project, you will need:
- **Java JDK 17 or higher** (JDK 25 recommended based on project settings).
- **IntelliJ IDEA** (or any Maven-compatible IDE).
- The **Weka library** (automatically handled by the included `pom.xml`).

## ⚙️ How to Run
1. **Clone or Download** this repository to your local machine.
2. Open the project folder in **IntelliJ IDEA**.
3. Allow **Maven** to download the dependencies (this happens automatically when you open `pom.xml`).
4. Navigate to `src/main/java/FraudDetector.java`.
5. Right-click and select **Run 'FraudDetector.main()'**.
6. A graphical window will pop up showing the **Decision Tree Flowchart**.

## 📊 Dataset
The model was trained on a dataset of credit card transactions (Kaggle), featuring 30 numerical attributes including PCA-transformed variables.

---
**Developer:** Emmanuel Mensah  
**Institution:** University of Mines and Technology (UMaT)-SRID
