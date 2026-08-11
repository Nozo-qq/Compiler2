from flask import Flask, render_template, request, redirect, url_for, send_from_directory

app = Flask(__name__)

# Serve images folder
@app.route("/images/<path:filename>")
def images(filename):
    return send_from_directory("images", filename)



# In-memory product list
products = [
    {
        "id": 1,
        "name": "Laptop",
        "price": 999,
        "description": "Fast and reliable laptop.",
        "image": "laptop.jpg",
        "deleted": False
    },
    {
        "id": 2,
        "name": "Phone",
        "price": 499,
        "description": "High-quality camera smartphone.",
        "image": "phone.jpg",
        "deleted": False
    },
    {
        "id": 3,
        "name": "Headphones",
        "price": 199,
        "description": "Noise-cancelling headphones.",
        "image": "headphones.jpg",
        "deleted": False
    }
]

# Home page – list products
@app.route("/")

def home():
    visible_products = []
    for p in products:
        if p["deleted"] == False:
            visible_products.append(p)
    return render_template("index.html", products=visible_products)

# Product details page
@app.route("/product/<int:product_id>")
def product_details(product_id):
    product = None
    for p in products:
        if p["id"] == product_id:
            if p["deleted"] == False:
                product = p
            break
    return render_template("product.html", product=product)

# Delete a product (soft delete - this language subset has no way to shrink
# a list in place: no pop/remove/del/global, so we flag instead of removing)
@app.route("/delete/<int:product_id>", methods=["POST"])
def delete_product(product_id):
    for p in products:
        if p["id"] == product_id:
            p["deleted"] = True
            break
    return redirect(url_for("home"))

# Add product form (GET + POST)
@app.route("/add", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        # Calculate next ID without ternary or comprehension
        new_id = 1
        if products:
            max_id = products[0]["id"]
            for p in products:
                if p["id"] > max_id:
                    max_id = p["id"]
            new_id = max_id + 1

        new_product = {
            "id": new_id,
            "name": request.form["name"],
            "price": float(request.form["price"]),
            "description": request.form["description"],
            "image": request.form["image"],
            "deleted": False
        }

        products.append(new_product)
        return redirect(url_for("home"))

    return render_template("add_product.html")

# Optional: run server
# if __name__ == "__main__":
#     app.run(debug=True, port=5001)