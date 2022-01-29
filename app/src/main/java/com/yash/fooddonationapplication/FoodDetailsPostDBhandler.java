package com.yash.fooddonationapplication;

import android.widget.EditText;

public class FoodDetailsPostDBhandler {
        // variables for storing our data.
    private String quantText,perishabilityText, nutritionalValueText, personsFedText,DonorFoodDetailsText,postName;

        public FoodDetailsPostDBhandler() {
            // empty constructor
            // required for Firebase.
        }

        // Constructor for all variables.
        public FoodDetailsPostDBhandler(String postName,String quantText,String perishabilityText,String nutritionalValueText,
                                        String personsFedText,String DonorFoodDetailsText) {
            this.quantText = quantText;
            this.perishabilityText = perishabilityText;
            this.nutritionalValueText = nutritionalValueText;
            this.personsFedText = personsFedText;
            this.DonorFoodDetailsText = DonorFoodDetailsText;
            this.postName = postName;
        }

        // getter methods for all variables.
        public String getPostName() {
            return postName;
        }
        public void setPostName(String postName) {
            this.postName = postName;
        }
        public String getQuantText() {
            return quantText;
        }
        public void setQuantText(String quantText) {
            this.quantText = quantText;
        }
        public String getperishability() {
            return perishabilityText;
        }

        // setter method for all variables.
        public void setperishability(String perishabilityText) {
            this.perishabilityText = perishabilityText;
        }

        public String getnutritionalValue() {
            return nutritionalValueText;
        }

        public void setnutritionalValue(String nutritionalValueText) {
            this.nutritionalValueText = nutritionalValueText;
        }
    public String getpersonsFed() {
        return personsFedText;
    }

    public void setpersonsFedText(String personsFedText) {
        this.personsFedText = personsFedText;
    }
    public String getDonorFoodDetails() {
        return DonorFoodDetailsText;
    }
    public void setDonorFoodDetails(String DonorFoodDetailsText) {
        this.DonorFoodDetailsText = DonorFoodDetailsText;
    }
    }

