
#### B.  Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.


#### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
###### Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.
>`mainscreen.html: lines 14,19 -> changed title tag and h1 to "Josh's Tennis Shop" `
#### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
`about.html: -> created file with bootstrap boilerplate`
`about.html: lines 18-22 -> added header and paragraph describing company, added inline styles`
`about.html: lines 19-25 -> created nav bar and wrapped nav and h1 in header tag`
`mainscreen.html: lines 18-25 -> created nav bar and wrapped nav and h1 in header tag `
`AboutController: created class and added URL mapping returning template`
#### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
`BootStrapData: lines 36,40, 46-56`

###### Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.


#### F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
1.  The “Buy Now” button must be next to the buttons that update and delete products.
2. The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
3.  Display a message that indicates the success or failure of a purchase.


#### G.  Modify the parts to track maximum and minimum inventory by doing the following:
1.  Add additional fields to the part entity for maximum and minimum inventory.
2.  Modify the sample inventory to include the maximum and minimum fields.
3.  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
4.  Rename the file the persistent storage is saved to.
5. Modify the code to enforce that the inventory is between or at the minimum and maximum value.


#### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
1. Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
2. Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
`EnufPartsValidator: lines 35-41 -> honestly it seems like the code here that was included from the starter code already successfuly 
enforced this. However, I did go ahead and refactor by abstracting invDiff at line 35 and also changing logic to work when product.getInv() < myProduct.getInv()`
3. Display error messages when adding and updating parts if the inventory is greater than the maximum.


#### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


#### J.  Remove the class files for any unused validators in order to clean your code.


#### K.  Demonstrate professional communication in the content and presentation of your submission.
