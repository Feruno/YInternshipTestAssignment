package testAPI.data;

import testAPI.data.APIHelper;

import java.io.File;

public class DataGenerator {

    public static APIHelper.APIInfoPet getСorrectInfoPetCatAPI() {
        var PetCategory = new APIHelper.APIInfoPetCategory("16", "Mafin");
        return new APIHelper.APIInfoPet("16", PetCategory, "cat", "available");
    }

    public static APIHelper.APIInfoPet getСorrectModifiedInfoPetAPI() {
        var PetCategory = new APIHelper.APIInfoPetCategory("16", "Filin");
        return new APIHelper.APIInfoPet("16", PetCategory, "cat", "unavailable");
    }

    public static APIHelper.APIInfoPet getСorrectInfoPetDogAPI() {
        var PetCategory = new APIHelper.APIInfoPetCategory("18", "Bobik");
        return new APIHelper.APIInfoPet("18", PetCategory, "dog", "available");
    }

    public static APIHelper.APIInfoPet getInvalidInfoPetCatAPI() {
        var PetCategory = new APIHelper.APIInfoPetCategory("notNumberId", "Mafin");
        return new APIHelper.APIInfoPet("notNumberId", PetCategory, "cat", "available");
    }
}
