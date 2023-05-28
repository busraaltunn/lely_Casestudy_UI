Feature:lunaEur

  Background: user is on the technical document page
    Given user is on the technical document page

    @testB
    Scenario: Users should select Luna Eur from dropdown menu and then they should view and download it
      When Users can select “LUNA EUR” from the dropdown and verify that the catalogs can be seen
      When Users can view the document and verify that it is opened on a new tab
      And Users can  return to the previous tab and download the document
      Then Users should verify that it is downloaded