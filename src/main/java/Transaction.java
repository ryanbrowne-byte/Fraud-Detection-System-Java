
    public class Transaction {
        private String id;
        private double amount;
        private String location;
        private int hourOfDay;
        private boolean isInternational;

        public Transaction(String id, double amount, String location, int hourOfDay, boolean isInternational) {
            this.id = id;
            this.amount = amount;
            this.location = location;
            this.hourOfDay = hourOfDay;
            this.isInternational = isInternational;
        }

        public double calculateRiskScore() {
            double score = 0.0;
            if (this.amount > 500) score += 0.4; // High amount
            if (this.amount % 100 == 0 && this.amount > 0) score += 0.2;
            if (this.isInternational) score += 0.3; // Location risk
            return score;
        }
    }

