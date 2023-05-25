

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="w-full h-full">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/head.jsp" %> 
        <title>Create Order</title>
    </head>
    <body class=" w-full h-full flex items-center justify-center">
        <form class="w-full max-w-lg" action="create-order" method="post">
            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full md:w- px-3 mb-6 md:mb-0">

                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="location-id">
                        Location id
                    </label>
                    <input id="location-id" type="text" placeholder="12ASDF243DASF1" name="location-id" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" >
                    <p class="text-gray-600 text-xs italic">Please fill out this field.</p>
                </div>
                <!--<div class="w-full md:w-1/2 px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="idempotency-key">
                        Idempotency key
                    </label>
                    <input id="idempotency-key" type="text" placeholder="AKSJFKAS1234JAKSDJK1234" name="idempotency-key"  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" >
                    <p class="text-gray-600 text-xs italic">please you try it that it UUID be Unique</p>
                </div> 
                -->

            </div>
            <!-- 
            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-password">
                        Password
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="grid-password" type="password" placeholder="******************">
                    <p class="text-gray-600 text-xs italic">Make it as long and as crazy as you'd like</p>
                </div>
            </div>
            -->
            <div class="flex flex-wrap -mx-3 mb-2">
                <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="quantity-product">
                        Quantity Product
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="quantity-product"  name="quantity-product" type="number" placeholder="1">
                </div>
                <!-- 
                <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-state">
                        State
                    </label>
                    <div class="relative">
                        <select class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="grid-state">
                            <option>New Mexico</option>
                            <option>Missouri</option>
                            <option>Texas</option>
                        </select>
                        <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                            <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/></svg>
                        </div>
                    </div>
                </div>
                -->

                <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="catalog-object-id">
                        Catalog Object Id
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="catalog-object-id" name="catalog-object-id" type="text" placeholder="AS786AFSD6F8AS">
                    <p class="text-gray-600 text-xs italic">This id has to be unique</p>
                </div>
            </div>


        </div>
        <div class="flex flex-wrap -mx-3 mb-2">
            <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="quantity-modifier">
                    Quantity Modifier
                </label>
                <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="quantity-modifier"  name="quantity-modifier" type="number" placeholder="1">
            </div>
            

            <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="modifier-id">
                    Modifier Id
                </label>
                <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="modifier-id" name="modifier-id" type="text" placeholder="AS786AFSD6F8AS">
                <p class="text-gray-600 text-xs italic">This id has to be unique</p>
            </div>
        </div>


        <div class="flex flex-wrap -mx-3 mb-6">
            <div class="w-full px-3">

                <button class="appearance-none block w-full bg-gray-200 text-gray-600 border border-gray-600 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-900"  type="submit" >
                    Send
                </button>   


            </div>
        </div>
    </form>
</body>
</html>
