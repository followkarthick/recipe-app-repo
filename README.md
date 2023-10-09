# ✨ Recipe 🌶️🥔🍄‍🥕 🍔 Application ✨

## Docker instructions:

1) Please go to the root folder where **Dockerfile** is located

2) Open **terminal**

3) Execute the below command for docker build with tag 1.0

	docker build -t recipe:1.0 .

4) Execute the below command for mapping the port number

	docker run -d -p 8090:8090 -t recipe:1.0
   
5) View list of containers using below command

	docker ps
 		
------------------------------------------------------------------------------------------
   
## Swagger Info:

	http://localhost:8090/swagger-ui.html#/
		
> On ** Swagger UI **, we will be able to see the below two controllers and their respective methods under them

>   ** Ingredient Controller **

> - Create an ingredient
	
> - Delete the ingredient
	
> - List one ingredient by its ID
	
> - List all ingredients

> ** Recipe Controller  **

> - Create a recipe
	
> - Delete the recipe
	
> - Update the recipe
	
> - List one recipe by its ID
	
> - List all recipes
	
> - Search recipes by given parameters


