

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="w-full ">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/head.jsp" %> 
        <title>Create Order</title>
        <script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
        <script src="lodash.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.1/axios.min.js"></script>

    </head>
    <body class=" w-full  flex items-center justify-center overflow-auto	">

        <form class="w-full max-w-lg" id="form-upload-order" method="post" action="/create-order">
            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="location-id">
                        Location ID
                    </label>
                    <input id="location-id" type="text" placeholder="DD8J38D92DDQ2" name="location_id" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />
                    <p class="text-gray-600 text-xs italic">Please fill out this field.</p>
                </div>
            </div>

            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="state">
                        State
                    </label>
                    <input id="state" type="text" placeholder="OPEN" name="state" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />
                    <p class="text-gray-600 text-xs italic">Please fill out this field.</p>
                </div>
            </div>

            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="customer-id">
                        Customer ID
                    </label>
                    <input id="customer-id" type="text" placeholder="GPATV3YXEWC6SN29B3DMDWSM8W" name="customer_id" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />
                    <p class="text-gray-600 text-xs italic">Please fill out this field.</p>
                </div>
            </div>

            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                        Line Items
                    </label>

                    <div id="line-items-container">


                        <!-- Aquí se agregarán los campos de los line items dinámicamente -->
                    </div>


                    <button id="buttonAddLineItem" type="button" class="appearance-none block bg-gray-200 text-gray-600 border border-gray-600 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-900">
                        Add Line Item
                    </button>
                </div>
            </div>

            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="ticket-name">
                        Ticket Name
                    </label>
                    <input id="ticket-name" type="text" placeholder="ticket name" name="ticket_name" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />
                    <p class="text-gray-600 text-xs italic">Please fill out this field.</p>
                </div>
            </div>

            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                        Taxes
                    </label>

                    <div id="taxes-container" >
                        <!-- Aquí se agregarán los campos de los taxes dinámicamente -->
                    </div>

                    <button id="buttonAddTax" type="button" class="appearance-none block bg-gray-200 text-gray-600 border border-gray-600 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-900">
                        Add Tax
                    </button>
                </div>
            </div>

            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                        Fulfillments
                    </label>

                    <div id="fulfillments-container" >
                        <!-- Aquí se agregarán los campos de los taxes dinámicamente -->
                    </div>

                    <button id="buttonAddFulfillments" type="button" class="appearance-none block bg-gray-200 text-gray-600 border border-gray-600 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-900">
                        Add fulfillment
                    </button>
                </div>
            </div>
            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="source_id">
                        Source Id
                    </label>
                    <input id="source_id" type="text" placeholder="" name="source_id" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />

                </div>
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="reference_id">
                        Reference id
                    </label>
                    <input id="reference_id" type="text" placeholder="" name="reference_id" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />

                </div>
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="source">
                        Source
                    </label>
                    <input id="source" type="text" placeholder="" name="external_details[source]" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />

                </div>
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="type">
                        Type
                    </label>
                    <input id="type" type="text" placeholder="" name="external_details[type]" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />

                </div>
                <div class="w-full md:w- px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="source_id">
                        Source Id
                    </label>
                    <input id="source_id" type="text" placeholder="" name="external_details[source_id]" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" />

                </div>
            </div>


            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full px-3">
                    <button id="buttonSend" type="submit" class="appearance-none block w-full bg-gray-200 text-gray-600 border border-gray-600 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-900">
                        Send
                    </button>
                </div>
            </div>
        </form>
        <script>
            var contadorLineItems = 0;
            var contadorTaxes = 0;
            var contadorModifiers = [];
            contadorFulfillments = 0;

            class stadoModifier {
                Constructor(contador) {
                    this.contador = contador;
                }
                getContador() {
                    return this.contador;

                }
                setContador() {
                    this.contador = this.contador + 1;
                }
            }

            function agregarLineItem() {
                var lineItemsContainer = document.getElementById("line-items-container");


                var divLineItem = document.createElement("div");
                divLineItem.className = "line-item flex flex-wrap";

                var labelQuantity = document.createElement("label");
                labelQuantity.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelQuantity.textContent = "Quantity";

                var inputQuantity = document.createElement("input");
                inputQuantity.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputQuantity.name = "line_items[" + contadorLineItems + "][quantity]";
                inputQuantity.type = "text";

                var labelCatalogObjectId = document.createElement("label");
                labelCatalogObjectId.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelCatalogObjectId.textContent = "Catalog Object ID";

                var inputCatalogObjectId = document.createElement("input");
                inputCatalogObjectId.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputCatalogObjectId.name = "line_items[" + contadorLineItems + "][catalog_object_id]";
                inputCatalogObjectId.type = "text";

                var labelItemType = document.createElement("label");
                labelItemType.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelItemType.textContent = "ITEM TYPE";

                var inputItemType = document.createElement("input");
                inputItemType.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputItemType.name = "line_items[" + contadorLineItems + "][item_type]";


                var divLineItemModifier = document.createElement("div");
                divLineItem.className = "w-full px-3 flex flex-wrap block";
                var labelLineItemModifier = document.createElement("label");
                labelLineItemModifier.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelLineItemModifier.textContent = "MODIFIER";

                var ButtonAddModifiers = document.createElement("button");
                ButtonAddModifiers.className = "appearance-none block bg-gray-200 text-gray-600 border border-gray-600 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-900";
                ButtonAddModifiers.data = "Modifiers";
                ButtonAddModifiers.textContent = "Modifiers";
                ButtonAddModifiers.setAttribute("type", "button");
                ButtonAddModifiers.setAttribute("id", "button-" + contadorLineItems);
                ButtonAddModifiers.addEventListener("click", agregarModifiers);

                var anotherdiv = document.createElement("div");
                anotherdiv.setAttribute("id", "container-modifier-" + contadorLineItems);

                divLineItemModifier.appendChild(labelLineItemModifier);
                divLineItemModifier.appendChild(anotherdiv);
                divLineItemModifier.appendChild(ButtonAddModifiers);



                divLineItem.appendChild(labelQuantity);
                divLineItem.appendChild(inputQuantity);
                divLineItem.appendChild(labelCatalogObjectId);
                divLineItem.appendChild(inputCatalogObjectId);
                divLineItem.appendChild(labelItemType);
                divLineItem.appendChild(inputItemType);
                divLineItem.appendChild(divLineItemModifier);


                //divLineItem.appendChild(ButtonAddModifiers);

                lineItemsContainer.appendChild(divLineItem);
                contadorModifiers = [...contadorModifiers, {contador: 0}];

                contadorLineItems++;
            }

            function agregarTax() {
                var taxesContainer = document.getElementById("taxes-container");

                var divTax = document.createElement("div");
                divTax.className = "tax";

                var labelCatalogObjectId = document.createElement("label");
                labelCatalogObjectId.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelCatalogObjectId.textContent = "Catalog Object ID";

                var inputCatalogObjectId = document.createElement("input");
                inputCatalogObjectId.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputCatalogObjectId.name = "taxes[" + contadorTaxes + "][catalog_object_id]";
                inputCatalogObjectId.type = "text";

                var labelCataloVersion = document.createElement("label");
                labelCataloVersion.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelCataloVersion.textContent = "Catalog Version";

                var inputCatalogVersion = document.createElement("input");
                inputCatalogVersion.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputCatalogVersion.name = "taxes[" + contadorTaxes + "][catalog_version]";
                inputCatalogVersion.type = "text";

                divTax.appendChild(labelCatalogObjectId);
                divTax.appendChild(inputCatalogObjectId);
                divTax.appendChild(labelCataloVersion);
                divTax.appendChild(inputCatalogVersion);

                taxesContainer.appendChild(divTax);


                contadorTaxes++;
            }
            function agregarModifiers(e) {
                console.log(e);
                var indice = event.target.id.split("-")[1];
                console.log(indice);


                var ModifiersContainer = document.getElementById("container-modifier-" + indice);


                var divModifiers = document.createElement("div");
                divModifiers.className = "modifiers";

                var labelCatalogObjectId = document.createElement("label");
                labelCatalogObjectId.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelCatalogObjectId.textContent = "Catalog Object ID MODIFIER";

                var inputCatalogObjectId = document.createElement("input");
                inputCatalogObjectId.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                //line_items[" + contadorLineItems + "][item_type]        
                inputCatalogObjectId.name = "line_items[" + (indice) + "][modifiers][" + (contadorModifiers[parseInt(indice)]).contador + "][catalog_object_id]";
                inputCatalogObjectId.type = "text";

                var labelCataloVersion = document.createElement("label");
                labelCataloVersion.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelCataloVersion.textContent = "QUANTITY MODIFIER";

                var inputCatalogVersion = document.createElement("input");
                inputCatalogVersion.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputCatalogVersion.name = "line_items[" + (indice) + "][modifiers][" + contadorModifiers[parseInt(indice)].contador + "][quantity]";
                inputCatalogVersion.type = "text";

                divModifiers.appendChild(labelCatalogObjectId);
                divModifiers.appendChild(inputCatalogObjectId);
                divModifiers.appendChild(labelCataloVersion);
                divModifiers.appendChild(inputCatalogVersion);

                ModifiersContainer.appendChild(divModifiers);

                contadorModifiers[parseInt(indice)].contador++;


            }
            function agregarFulfillments() {
                var fulfillment = document.getElementById("fulfillments-container");

                var divLineItem = document.createElement("div");
                divLineItem.className = "w-full px-3 flex flex-wrap block";
                divLineItem.className = "line-item flex flex-wrap";

                var labelType = document.createElement("label");
                labelType.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelType.textContent = "Type";

                var inputType = document.createElement("input");
                inputType.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputType.name = "fulfillments[" + contadorFulfillments + "][type]";
                inputType.type = "text";


                var labelDisplayName = document.createElement("label");
                labelDisplayName.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelDisplayName.textContent = "Display Name";

                var inputDisplayName = document.createElement("input");
                inputDisplayName.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputDisplayName.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][display_name]";
                inputDisplayName.type = "text";

                var labelEmailAddress = document.createElement("label");
                labelEmailAddress.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelEmailAddress.textContent = "Email Address";

                var inputEmailAddress = document.createElement("input");
                inputEmailAddress.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputEmailAddress.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][email_address]";
                inputEmailAddress.type = "text";

                var labelPhoneNumber = document.createElement("label");
                labelPhoneNumber.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelPhoneNumber.textContent = "Phone Number";

                var inputPhoneNumber = document.createElement("input");
                inputPhoneNumber.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputPhoneNumber.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][phone_number]";
                inputPhoneNumber.type = "text";

                var containerAdrress = document.createElement("div");
                containerAdrress.setAttribute("id", "containerAddress");

                var labelAddressLine1 = document.createElement("label");
                labelAddressLine1.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelAddressLine1.textContent = "Address Line 1";

                var inputAddressLine1 = document.createElement("input");
                inputAddressLine1.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputAddressLine1.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][address_line_1]";
                inputAddressLine1.type = "text";

                var labelAddressLine2 = document.createElement("label");
                labelAddressLine2.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelAddressLine2.textContent = "Address Line 2";

                var inputAddressLine2 = document.createElement("input");
                inputAddressLine2.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputAddressLine2.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][address_line_2]";
                inputAddressLine2.type = "text";

                var labelAddressLine3 = document.createElement("label");
                labelAddressLine3.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelAddressLine3.textContent = "Address Line 3";

                var inputAddressLine3 = document.createElement("input");
                inputAddressLine3.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputAddressLine3.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][address_line_3]";
                inputAddressLine3.type = "text";

                var labelAdministrative_district_level_1 = document.createElement("label");
                labelAdministrative_district_level_1.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelAdministrative_district_level_1.textContent = "Administrative District Level 1";

                var inputAdministrative_district_level_1 = document.createElement("input");
                inputAdministrative_district_level_1.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputAdministrative_district_level_1.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][administrative_district_level_1]";
                inputAdministrative_district_level_1.type = "text";

                var labelAdministrative_district_level_2 = document.createElement("label");
                labelAdministrative_district_level_2.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelAdministrative_district_level_2.textContent = "Administrative District Level 2";

                var inputAdministrative_district_level_2 = document.createElement("input");
                inputAdministrative_district_level_2.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputAdministrative_district_level_2.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][administrative_district_level_2]";
                inputAdministrative_district_level_2.type = "text";


                var labelAdministrative_district_level_3 = document.createElement("label");
                labelAdministrative_district_level_3.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelAdministrative_district_level_3.textContent = "Administrative District Level 3";

                var inputAdministrative_district_level_3 = document.createElement("input");
                inputAdministrative_district_level_3.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputAdministrative_district_level_3.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][administrative_district_level_3]";
                inputAdministrative_district_level_3.type = "text";

                var labelCountry = document.createElement("label");
                labelCountry.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelCountry.textContent = "Country";

                var inputCountry = document.createElement("input");
                inputCountry.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputCountry.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][country]";
                inputCountry.type = "text";

                var labelLocality = document.createElement("label");
                labelLocality.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelLocality.textContent = "Locality";

                var inputLocality = document.createElement("input");
                inputLocality.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputLocality.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][locality]";
                inputLocality.type = "text";

                var labelPostalCode = document.createElement("label");
                labelPostalCode.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelPostalCode.textContent = "Postal Code";

                var inputPostalCode = document.createElement("input");
                inputPostalCode.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                inputPostalCode.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][postal_code]";
                inputPostalCode.type = "text";

                var labelSublocality = document.createElement("label");
                labelSublocality.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelSublocality.textContent = "Sublocality";

                var InputSublocality = document.createElement("input");
                InputSublocality.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                InputSublocality.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][sublocality]";
                InputSublocality.type = "text";


                var labelSublocality_2 = document.createElement("label");
                labelSublocality_2.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelSublocality_2.textContent = "Sublocality 1";

                var InputSublocality_2 = document.createElement("input");
                InputSublocality_2.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                InputSublocality_2.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][sublocality_2]";
                InputSublocality_2.type = "text";

                var labelSublocality_3 = document.createElement("label");
                labelSublocality_3.className = "block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2";
                labelSublocality_3.textContent = "Sublocality 2";

                var InputSublocality_3 = document.createElement("input");
                InputSublocality_3.className = "appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500";
                InputSublocality_3.name = "fulfillments[" + contadorFulfillments + "][shipment_details][recipient][address][sublocality_3]";
                InputSublocality_3.type = "text";


                containerAdrress.appendChild(labelAddressLine1);
                containerAdrress.appendChild(inputAddressLine1);
                containerAdrress.appendChild(labelAddressLine2);
                containerAdrress.appendChild(inputAddressLine2);
                containerAdrress.appendChild(labelAddressLine3);
                containerAdrress.appendChild(inputAddressLine3);
                containerAdrress.appendChild(labelAdministrative_district_level_1);
                containerAdrress.appendChild(inputAdministrative_district_level_1);
                containerAdrress.appendChild(labelAdministrative_district_level_2);
                containerAdrress.appendChild(inputAdministrative_district_level_2);
                containerAdrress.appendChild(labelAdministrative_district_level_3);
                containerAdrress.appendChild(inputAdministrative_district_level_3);
                containerAdrress.appendChild(labelCountry);
                containerAdrress.appendChild(inputCountry);
                containerAdrress.appendChild(labelLocality);
                containerAdrress.appendChild(inputLocality);
                containerAdrress.appendChild(labelPostalCode);
                containerAdrress.appendChild(inputPostalCode);
                containerAdrress.appendChild(labelSublocality);
                containerAdrress.appendChild(InputSublocality);
                containerAdrress.appendChild(labelSublocality_2);
                containerAdrress.appendChild(InputSublocality_2);
                containerAdrress.appendChild(labelSublocality_3);
                containerAdrress.appendChild(InputSublocality_3);


                var divContainerShipmentDetails = document.createElement("div");
                divContainerShipmentDetails.appendChild(labelDisplayName);
                divContainerShipmentDetails.appendChild(inputDisplayName);
                divContainerShipmentDetails.appendChild(labelEmailAddress);
                divContainerShipmentDetails.appendChild(inputEmailAddress);
                divContainerShipmentDetails.appendChild(labelPhoneNumber);
                divContainerShipmentDetails.appendChild(inputPhoneNumber);
                divContainerShipmentDetails.appendChild(containerAdrress);




                divLineItem.appendChild(labelType);
                divLineItem.appendChild(inputType);
                divLineItem.appendChild(divContainerShipmentDetails);




                //divLineItem.appendChild(ButtonAddModifiers);

                fulfillment.appendChild(divLineItem);


                contadorFulfillments++;
            }

            function obtenerValoresFormulario() {
                var formulario = document.getElementById("form-upload-order");
                var campos = formulario.elements;

                var valores = {};
                for (var i = 0; i < campos.length; i++) {
                    var campo = campos[i];

                    if (campo.name !== "") {
                        var clave = campo.name;
                        var valor = campo.value;
                        valores[clave] = valor;

                    }

                }
                const result = {};

                for (const key in valores) {
                    const value = valores[key];
                    const parsedKey = key.replace(/\[(\d+)\]/g, '.$1'); // Convertir la notación de índice en notación de punto
                    _.set(result, parsedKey, value);
                }

                console.log(result);




                return result;
            }

            function miFuncionEvento(event) {
                event.preventDefault();
                var valoresFormulario = obtenerValoresFormulario();
                axios.post("create-order", valoresFormulario).then(function (response) {
                    const {title, mensaje, order_id} = response.data;
                    console.log(title, mensaje, order_id)
                    window.location.href = "RegistroExitoso.jsp?mensaje="+ mensaje+"&title=" +title+"&order_id=" +order_id;

                }).catch(error => {
                    // Manejar errores de la solicitud
                    console.error(error);
                });
                console.log(valoresFormulario);
                // Realizar acciones adicionales con los valores del formulario
            }

            var botonEnviar = document.getElementById("buttonSend");
            botonEnviar.addEventListener("click", miFuncionEvento);

            var botonAgregarLineItem = document.getElementById("buttonAddLineItem");
            botonAgregarLineItem.addEventListener("click", agregarLineItem);

            var botonAgregarTax = document.getElementById("buttonAddTax");
            botonAgregarTax.addEventListener("click", agregarTax);


            var botonAgregarFulfillments = document.getElementById("buttonAddFulfillments");
            botonAgregarFulfillments.addEventListener("click", agregarFulfillments);

        </script>
    </body>
</html>
