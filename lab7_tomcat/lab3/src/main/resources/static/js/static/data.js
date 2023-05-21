class Order {
    constructor(id, date, price, paid) {
        this.id = id;
        this.date = date;
        this.paid = paid;
        this.price = price;
    }

    toString() {
        return `#${this.id}: ${this.paid}`;
    }
}

const Orders = [
    new Order(0, new Date('2023-02-28 12:20:05.000000'), '300', 'Yes'),
    new Order(1, new Date('2023-02-26 12:18:54.000000'), '100', 'Yes'),
    new Order(2, new Date('2023-02-28 12:20:05.000000'), '290', 'Yes'),
    new Order(3, new Date('2023-02-23 15:10:14.000000'), '530', 'No'),
    new Order(4, new Date('2023-02-23 15:10:14.000000'), '80', 'Yes'),
]
