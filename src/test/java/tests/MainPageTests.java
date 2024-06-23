package tests;

import components.SubmitRequestComponent;
import extensions.io.qameta.allure.Manual;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

@Tag("smoke_tests")
@Feature("hflabs.ru")
@Story("Main page tests")
@Owner("ivanov-ev")
@Severity(SeverityLevel.NORMAL)
@Link(name = "https://hflabs.ru/", url = "https://hflabs.ru/")
@DisplayName("Main page tests")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    SubmitRequestComponent submitRequestComponent = new SubmitRequestComponent();

    @Test
    @DisplayName("Click the close icon in the cookies bottom bar to close the bar")
    void closeCookiesBarTest() {
        mainPage.openPage()
                .closeCookiesBar()
                .cookiesBarIsHidden();
    }

    @Test
    @DisplayName("Click the request submission button to open the form, and check the form is displayed correctly and can be closed")
    void checkFieldsOnSubmitRequestFormTest() {
        mainPage.openPage()
                .clickRequestSubmissionButton();
        submitRequestComponent.checkSubmissionForm()
                .closeSubmissionForm()
                .checkSubmissionFormIsClosed();
    }

    @Test
    @DisplayName("Change the language, and check the language is changed on the main page")
    void changeLanguageTest() {
        mainPage.openPage()
                .changeLanguageToEn()
                .checkLanguageIsEn()
                .changeLanguageToRu()
                .checkLanguageIsRu();
    }

    @Test
    @DisplayName("Click the 'Products' item in the top bar, and check its sub-menu's items and links")
    void checkProductsTopBarContentTest() {
        mainPage.openPage()
                .openProductsTopBar()
                .checkProductsTopBarTextsAndLinks();
    }

    @Test
    @DisplayName("Click the 'Company' item in the top bar, and check its sub-menu's items and links")
    void checkCompanyTopBarContentTest() {
        mainPage.openPage()
                .openCompanyTopBar()
                .checkCompanyTopBarTextsAndLinks();
    }

    @Test
    @Manual
    @Tag("desktop")
    @DisplayName("Check the customer stories block in the desktop view")
    void customerStoriesInDesktopViewTest() {
        step("Open the main page");
        step("Check the customer stories block", () -> {
                    step("The block has a title");
                    step("The block displays 3 items at a time");
                    step("Check the 1st item: it contains a customer's logo, a year, and some text");
                    step("The block displays the scroll left button and the scroll right button");
                }
        );
        step("Use the scroll buttons", () -> {
                    step("Click the scroll left button to make the 1st item move the 2nd position");
                    step("Click the scroll right button to make the 1st item move the 1nd position");
                    step("Click the scroll right button again to make the 1st item disappear");
                }
        );
    }
}
