const OrdersFormInputs = [
    {
        label: 'Orders date:',
        name: 'ordersDate',
        placeholder: 'Enter orders date...',
        styleClasses: [],
        type: "date",
        attributes: new Map([
            ['data-validation', 'true'],
            ['data-validation-params', 'require'],
        ])
    },
]

function onLoadPage() {
    const resultContainer = document.getElementById('orders-result');

    generateForm('orders-form', OrdersFormInputs, "Show orders");
    generateForm('all-orders-form', [], "Show all orders");

    const ordersForm = document.getElementById('orders-form');
    ordersForm.onsubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const searchQuery = {date: formData.get('ordersDate'),}

        const orders = getOrdersByQuery(Orders, searchQuery);
        printResult(resultContainer, orders);
    };

    const allOrdersForm = document.getElementById('all-orders-form');
    allOrdersForm.onsubmit = (e) => {
        e.preventDefault();
        printResult(resultContainer, Orders);
    };

    initInputValidation('orders-form');
}


function getOrdersByQuery(orders, searchQuery) {
    return orders.filter(order => {
        return new Date(order.date).toDateString() === new Date(searchQuery.date).toDateString();
    });
}

function printResult(resultContainer, result) {
    resultContainer.innerHTML = '';
    const resultTable = createResultTable(
        result,
        'orders-table',
        'orders-table__header',
        'orders-table__row',
        'orders-table__col',
    );
    resultContainer.append(resultTable);
}