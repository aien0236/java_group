// JavaScript will go here
document.addEventListener('DOMContentLoaded', function () {
    var buttons = document.querySelectorAll('.food-button');
        buttons.forEach(function (button) {
            button.addEventListener('click', function () {
            // You can replace the alert with the actual functionality you need
            window.location.href = 'ConsumerServlet?purpose=sort-by-food-type&foodtype=' + button.id;
        });
    });
});

const cartButton = document.getElementById('cart');
const cartContainer = document.querySelector('.cart-container');
let isCartVisible = false;
cartButton.addEventListener('click', function() {
    if (isCartVisible) {
        cartContainer.style.display = 'none';
        isCartVisible = false;
    } else {
        cartContainer.style.display = 'block';
        isCartVisible = true;
    }
});


document.querySelectorAll('.foodForm').forEach(function(form) {
    form.addEventListener('submit', function(event) {
        event.preventDefault()

        var formData = new FormData(form);
        var id = formData.get('id');
        var number = formData.get('number');
        var foodName = formData.get('foodName');
        var price = formData.get('price');
        var discount = formData.get('discount');
        var foodType = formData.get('foodType');
        var quantity = formData.get('quantity');
        var expirationDate = formData.get('expirationDate');

        console.log("id:", id);
        console.log("Food Name:", foodName);
        console.log("Price:", price);
        console.log("Discount:", discount);
        console.log("Food Type:", foodType);
        console.log("Quantity:", quantity);
        console.log("Expiration Date:", expirationDate);

        addToCart(id, number, foodName, price, discount, foodType, quantity, expirationDate);
        calSubtotal(price * quantity * (1 - discount / 100))

    });
});

function addToCart(id, number, foodName, price, discount, foodType, quantity, expirationDate) {

    var newRow = document.createElement('tr');

    var tbody = document.querySelector('.table tbody');

    var input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'cartItemIds[]';
    input.value = id;

    document.getElementById('checkoutForm').appendChild(input);


    newRow.innerHTML =
        '<th scope="row">' + '<input type="hidden" name="number" value="' + number + '" />' + number+ '</th>' +
        '<td>' + foodName + '</td>' +
        '<td>' + quantity + '</td>' +
        '<td>' + price + '</td>' +
        '<td>' + discount + '</td>' +
        '<td class="text-right">' + price * quantity * (1 - discount / 100) + '</td>' +
        '<td><a href="#" class="text-danger"><i class="ri-delete-bin-3-line"></i></a></td>';

    tbody.appendChild(newRow);
}

function calSubtotal(itemPrice) {

    var subTotal = parseFloat(document.getElementById('subTotal').textContent.replace('$', ''));
    subTotal += itemPrice;
    document.getElementById('subTotal').textContent = `$${subTotal.toFixed(2)}`;

    var shipping = parseFloat(document.getElementById('shipping').textContent.replace('$', ''));
    var taxRate = 0.13;
    var tax = subTotal * taxRate;
    document.getElementById('tax').textContent = `$${tax.toFixed(2)}`;

    var totalAmount = subTotal + shipping + tax;
    document.getElementById('totalAmount').textContent = `$${totalAmount.toFixed(2)}`;
}

document.getElementById('checkout-btn').addEventListener('click', function() {
    document.getElementById('checkoutForm').submit();
});