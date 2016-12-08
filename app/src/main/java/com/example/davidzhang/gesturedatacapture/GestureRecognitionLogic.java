package com.example.davidzhang.gesturedatacapture;

/**
 * Created by davidzhang on 12/8/16.
 */

public class GestureRecognitionLogic {

    public String GestureToHub(String text1, String text2) {
        String toReturn = "";
        String gesture = text1;
        String lightStatus = text2;
        switch (gesture) {

            case "move left":
                switch (lightStatus) {
                    case "LightAlreadyOn":
                        break;
                    case "Normal":
                        toReturn = "turn on the light";
                        break;
                    case "Failure":
                        break;
                }


            case "move right":
                switch (lightStatus) {
                    case "LightAlreadyOff":
//				toReturn = "Hum, the light is not on now";
                        break;
                    case "Normal":
				toReturn = "turn off the light";

                        break;
                    case "Failure":
//				toReturn = "Sorry, I can not find the light";
                        break;
                }


            case "move up":
                switch (lightStatus) {

                    // light should be on first
                    case "Normal":
				toReturn = "10% brighter";
                        break;
                    // light is not on
                    case "Failure":
//				toReturn = "Please turn on the light first";
                        break;
                    case "full brightness":
//				toReturn = "Sorry, I can not go any brigher now";
                        break;
                }

            case "move down":
                switch (lightStatus) {

                    // light should be on first
                    case "Normal":
				toReturn = "10% dimmer";


                        break;
                    // light is not on
                    case "Failure":
//				toReturn = "Please turn on the light first";
                        break;

                }

            case "rotate clockwise":
                switch (lightStatus) {

                    // light should be on first
                    case "Normal":
                        toReturn = "change to next color";


                        break;
                    // light is not on
                    case "Failure":
//				toReturn = "Please turn on the light first";
                        break;

                }

            case "rotate counterclockwise":
                switch (lightStatus) {

                    // light should be on first
                    case "Normal":
                        toReturn = "change back to previous color";


                        break;
                    // light is not on
                    case "Failure":
//				toReturn = "Please turn on the light first";
                        break;

                }


        }


        return toReturn;
    }
}
