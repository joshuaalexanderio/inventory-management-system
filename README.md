> ### Formatting guide
> 
> ---
>
> Changes will be denoted as follows:  
> ***(filename):*** (linenumbers) `->` (description of changes)
>
>***Note:*** Omission of line numbers and arrow indicates entirely new file was created/added

#### B.  Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.


#### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
###### Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.
> ***mainscreen.html:*** 14,19 `->` Change title tag and h1 to "Josh's Tennis Shop". 
#### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
>***about.html:*** Create file with bootstrap boilerplate. 

>***about.html:*** 18-22 `->` Add header and paragraph describing company, add inline styles.

>***about.html:*** 19-25 `->` Create nav bar and wrapped nav and h1 in header tag.

>***mainscreen.html:*** 18-25 `->` Create nav bar and wrapped nav and h1 in header tag. 

>***AboutController:*** Create class and add URL mapping returning template. 
#### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
###### Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

>***BootStrapData:*** 47-128 `->` Add sample data for parts/products.
>***BootStrapData:*** 45-46 `->` Check if repositories are empty before adding sample data.


#### F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
1.  The “Buy Now” button must be next to the buttons that update and delete products.
    >***AddPartController:*** 55 `->` Refactor /deleteproduct URL mapping to /deleteProduct for consistency.  
    >***mainscreen.html:*** 20-25 `->`Refactor /deleteproduct to /deleteProduct (see above).  
    >***mainscreen.html:*** 100-101 `->` Add Buy Now button that sends product id with confirmation.  
2. The button should decrement the inventory of that product by one. It should not affect the inventory of the associated parts.  
    >***BuyProductController:*** Add BuyProductController which decrement inventory when successfully purchasing product, handles errors, and displays success or error message.3.  Display a message that indicates the success or failure of a purchase.  
    > ***mainscreen.html:*** 20-25 `->` Add conditionally rendered success/fail messages to mainscreen.  


#### G.  Modify the parts to track maximum and minimum inventory by doing the following:
1.  Add additional fields to the part entity for maximum and minimum inventory.
    >***Part:*** 31-34 `->` Add @Min annotation to enforce min value of 0 for minInv and maxInv.  
    >***Part*** 44, 48-49, 52, 57-58 `->` Update constructor with arguments and setters.  
    >***Part*** 101-108 `->` Implement setter and getter methods for minInv and maxInv.  

2.  Modify the sample inventory to include the maximum and minimum fields.
    >***BootStrapData:*** 64-65, 72-73, 80-81, 88-89, 95-96 `->` Set Min and Max inventory for sample parts.  
3.  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.  
>***
4.  Rename the file the persistent storage is saved to.
5. Modify the code to enforce that the inventory is between or at the minimum and maximum value.
    >***Part***: 113-115 `->` add isValidInv() method to be used in validation in controllers below.  
    >***AddInhousePartController, AddOutsourcedPartController:*** 43-49 -> added validation error to bindingResult  if inventory is outside range.    

#### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
1. Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.  
    >See G.5
2. Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
    >***EnufPartsValidator:*** lines 35-41 `->` honestly it seems like the code here that was included from the starter code already successfully
enforced this. However, I did go ahead and refactor by abstracting invDiff at line 35 and also changing logic to work when `product.getInv() < myProduct.getInv()`. 
3. Display error messages when adding and updating parts if the inventory is greater than the maximum.
    >See G.5


#### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


#### J.  Remove the class files for any unused validators in order to clean your code.


#### K.  Demonstrate professional communication in the content and presentation of your submission.
