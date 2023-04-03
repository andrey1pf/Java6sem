'use strict';
{
    class ordersStorage{
        constructor() {
            this.TLocalStorage = new TLocalStorage('orders');
        }

        addValue(){
            let id = document.getElementById('id').value;
            let id_customer = document.getElementById('id_customer').value;
            let id_task = document.getElementById('id_task').value;
            let price = document.getElementById('price').value;
            let paid = document.getElementById('paid').checked;
            let obj = {
                'id_customer': id_customer,
                'id_task': id_task,
                'price': price,
                'paid' : paid ? 'yes' : 'no',
            };

            if (id) {
                this.TLocalStorage.addValue(id, obj);
            } else {
                alert('Enter the values');
            }

            (function resetMainFrom() {
                document.getElementById('main-form').reset();
            })();

            console.log("hto")
        }

        getValue(){
            let infoField = document.getElementById('info').value;
            let infoBlock = document.getElementById('text-info');
            if (infoBlock.childNodes.length !== 0) {
                infoBlock.innerHTML = '';
            }
            let yourRecipeObj = this.TLocalStorage.getValue(infoField);

            if (!(infoField in this.TLocalStorage.lsParse)) {
                alert('Такого заказа не существует');
            } else {
                for (let key in yourRecipeObj) {
                    let yourRecipeStr = `${key}:  ${yourRecipeObj[key]}`;
                    let block = document.createElement("DIV");
                    let t = document.createTextNode(yourRecipeStr);
                    block.appendChild(t);
                    infoBlock.appendChild(block);
                }
            }
            (function() {
                document.getElementById('info-form').reset();
            })();
        }

        deleteValue(){
            let deleteField = document.getElementById('delete').value;
            if (!(deleteField in this.TLocalStorage.lsParse)) {
                alert('Такого заказа не существует');
            } else {
                this.TLocalStorage.deleteValue(deleteField);
                alert('Информация о заказе удалена');
            }
            (function() {
                document.getElementById('delete-form').reset();
            })()
        }

        getKeys(){
            let listOfOrders = this.TLocalStorage.getKeys();
            let allOrdersFrom = document.getElementById('list-orders');

            if (allOrdersFrom.childNodes.length !== 0) {
                allOrdersFrom.innerHTML = '';
            }

            if (listOfOrders.length === 0) {
                alert('Нет заказов');
            } else {
                for (let i = 0; i < listOfOrders.length; i++) {
                    let yourOrderStr = listOfOrders[i];
                    let allOrdersBlock = document.createElement("DIV");
                    let t = document.createTextNode(yourOrderStr);
                    allOrdersBlock.appendChild(t);
                    allOrdersFrom.appendChild(allOrdersBlock);
                }
            }
            this.TLocalStorage.getKeys();
        }
    }

    var ordersTable = new ordersStorage();
}
