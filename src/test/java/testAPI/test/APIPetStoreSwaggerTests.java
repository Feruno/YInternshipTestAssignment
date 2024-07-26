package testAPI.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testAPI.data.APIHelper;
import testAPI.data.DataGenerator;

public class APIPetStoreSwaggerTests {

    @Test
    void requestPostPetDogAvailable() {
        var petСorrectInfo = DataGenerator.getСorrectInfoPetDogAPI();
        var actualRequest = APIHelper.sendRequestPostPet(petСorrectInfo, 200);
        Assertions.assertEquals("Bobik", actualRequest.getCategory().getName());
    }

    @Test
    void requestGetPetAvailable() {
        var petСorrectInfo = DataGenerator.getСorrectInfoPetDogAPI();
        var actualRequest = APIHelper.sendRequestGetPet(petСorrectInfo.getId(), 200);
        Assertions.assertEquals("available", actualRequest.getStatus());
    }

    @Test
    void requestGetPetInvalidInfo() {
        var petInvalidInfo = DataGenerator.getInvalidInfoPetCatAPI();
        var actualRequest = APIHelper.sendRequestPostPet(petInvalidInfo, 500);
        Assertions.assertEquals(null, actualRequest.getId());
    }

    @Test
    void requestPostPet() {
        var petСorrectInfo = DataGenerator.getСorrectInfoPetCatAPI();
        var actualRequest = APIHelper.sendRequestPostPet(petСorrectInfo, 200);
        System.out.println("запрос  === " + actualRequest.getCategory().getName());
        Assertions.assertEquals("Mafin", actualRequest.getCategory().getName());
    }


    @Test
    void requestPutPet() {
        var petModifiedInfo = DataGenerator.getСorrectModifiedInfoPetAPI();
        var actualRequest = APIHelper.sendRequestPutPet(petModifiedInfo, 200);
        System.out.println("запрос  === " + actualRequest);
        Assertions.assertEquals("Filin", actualRequest.getCategory().getName());
        Assertions.assertEquals("unavailable", actualRequest.getStatus());
    }

    @Test
    void requestDeletePet() {
        var petСorrectInfo = DataGenerator.getСorrectInfoPetCatAPI();
        APIHelper.sendRequestPostPet(petСorrectInfo, 200);
        var actualRequest = APIHelper.sendRequestDELETEPet(petСorrectInfo.getId(), 200);

        Assertions.assertEquals(null, actualRequest.getId());
    }
}
