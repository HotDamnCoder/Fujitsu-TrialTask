package com.fujitsu.trial_task.deliveryFee;



class DeliveryFeeService {

    public static Double calculateRBF(String location, String vehicleType){
        switch (location.toLowerCase()) {
            case "tallinn":
                switch (vehicleType.toLowerCase()) {
                    case "car":
                        return 4.0;
                    case "scooter":
                        return 3.5;                  
                    case "bike":
                        return 3.0;
                }
                break;
            case "tartu":
                switch (vehicleType.toLowerCase()) {
                    case "car":
                        return 3.5;
                    case "scooter":
                        return 3.0;                 
                    case "bike":
                        return 2.5;
                }
                break;
            case "pärnu":
                switch (vehicleType.toLowerCase()) {
                    case "car":
                        return 3.0;
                    case "scooter":
                        return 2.5;                   
                    case "bike":
                        return 2.0;
                }
                break;
        }
        return 0.0;
    }
    
    public static Double calculateATEF(String vehicleType, double airTemp){
        vehicleType = vehicleType.toLowerCase();
        if(vehicleType.equals("scooter") || vehicleType.equals("bike")){
            if (airTemp < -10){
                return 1.0;
            }
            if(airTemp >= -10 && airTemp <= 0){
                return 0.5;
            }
        }
        return 0.0;
    }

    public static Double calculateWSEF(String vehicleType, double windSpeed){
        vehicleType = vehicleType.toLowerCase();
        if(vehicleType.equals("bike")){
            if (windSpeed >= 10 & windSpeed <=20){
                return 0.5;
            }
            if (windSpeed > 20) {
                return null;
            }
        }
        return 0.0;
    }

    public static Double calculateWPEF(String vehicleType, String weather){
        vehicleType = vehicleType.toLowerCase();
        weather = weather.toLowerCase();
        if(vehicleType.equals("scooter") || vehicleType.equals("bike")){
            if (weather.contains("snow") || weather.contains("sleet")){
                return 1.0;
            }
            if(weather.contains("rain")){
                return 0.5;
            }
            if (weather.contains("glaze") || weather.contains("hail") || weather.contains("thunder")){
                return null;
            }
        }
        return 0.0;
    }

    public static DeliveryFee calculateDeliveryFee(Double RBF, Double ATEF, Double WSEF, Double WPEF) {
        if (WSEF == null) {
            throw new DeliveryForbiddenException();
        }
        if (WPEF == null){
            throw new DeliveryForbiddenException();
        }
        return new DeliveryFee(RBF + ATEF + WSEF + WPEF);
    }
}
