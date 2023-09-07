package Test;

import Base.Setup;

import DataMethodo.apachi_POI;
import Pages.B_Results_page;
import Pages.C_AddToChart_page;
import Pages.D_ShoppingCart_Page;
import Pages.E_TodaySDeals_Page;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T1 extends Setup {
  //1- pages by locator == sebarete
    //2-DDT
    //3-CROSSBRWOSER

    @Test
    public void Test1() {
        B_Results_page Result_obj = homepage_obj.search_for("car accessories");
        C_AddToChart_page addtochartBottom_obj = Result_obj.Click_firest_item();
        addtochartBottom_obj.Click_AddtoCartBottom();
        D_ShoppingCart_Page ShoppingCartObj = homepage_obj.Click_ShoppingCartIcon();
        //10- assert for
        SoftAssert ass = new SoftAssert();
        //1>assert Quantity
        ass.assertTrue(ShoppingCartObj.Isquantity(1));
        //2> name assertion
        ass.assertEquals(addtochartBottom_obj.getProducttitle1().toLowerCase(), ShoppingCartObj.protuctTitle2().toLowerCase());
        //3>price assertion
        ass.assertEquals(addtochartBottom_obj.getProducprice1().toLowerCase(), ShoppingCartObj.protuctprice2().toLowerCase());
        ass.assertAll();

    }

    @Test
    public void Test2() throws InterruptedException {
        homepage_obj.Click_AllTap();
        E_TodaySDeals_Page TodaysDeals_obj = homepage_obj.Click_Todays_Deals();
        TodaysDeals_obj.ClickGrocery_box();
        TodaysDeals_obj.ClickMobilePhoneandAcessorys_box();
        TodaysDeals_obj.Click_Offer_box();
        TodaysDeals_obj.click_Firstproduct();
        C_AddToChart_page addtochartBottom_obj = TodaysDeals_obj.get_pageNo_4_ifexist();
        addtochartBottom_obj.Click_AddtoCartBottom();

        D_ShoppingCart_Page ShoppingCartObj = homepage_obj.Click_ShoppingCartIcon();
        SoftAssert ass = new SoftAssert();
        //1>assert Quantity
        ass.assertTrue(ShoppingCartObj.Isquantity(1));
        //2> name assertion
        ass.assertEquals(addtochartBottom_obj.getProducttitle1().toLowerCase(), ShoppingCartObj.protuctTitle2().toLowerCase());
        //3>price assertion
        ass.assertEquals(addtochartBottom_obj.getProducprice1().toLowerCase(), ShoppingCartObj.protuctprice2().toLowerCase());
        ass.assertAll();

    }
}

