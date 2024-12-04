from flask import Flask, render_template, request, jsonify, redirect, url_for, session

app = Flask(__name__)
app.secret_key = 'your_secret_key'

# Mock database
users = []

# Routes
@app.route('/')
def index():
    return render_template('index.html')

@app.route('/register', methods=['POST'])
def register():
    username = request.form.get('username')
    email = request.form.get('email')
    password = request.form.get('password')

    # Check if email already exists
    if any(user['email'] == email for user in users):
        return jsonify({"success": False, "message": "Email already registered!"}), 400

    users.append({'username': username, 'email': email, 'password': password})
    return jsonify({"success": True, "message": "Registration successful!"})

@app.route('/login', methods=['POST'])
def login():
    email = request.form.get('email')
    password = request.form.get('password')

    user = next((user for user in users if user['email'] == email and user['password'] == password), None)
    if user:
        session['username'] = user['username']
        return jsonify({"success": True, "message": "Login successful!"})
    else:
        return jsonify({"success": False, "message": "Invalid email or password!"}), 401

@app.route('/logout', methods=['POST'])
def logout():
    session.pop('username', None)
    return jsonify({"success": True, "message": "Logged out successfully!"})

@app.route('/payment', methods=['POST'])
def payment():
    card_number = request.form.get('cardNumber')
    expiry_date = request.form.get('expiryDate')
    cvv = request.form.get('cvv')

    # Validate payment details
    if len(card_number) != 16 or not card_number.isdigit():
        return jsonify({"success": False, "message": "Invalid card number!"}), 400

    if not expiry_date or '/' not in expiry_date:
        return jsonify({"success": False, "message": "Invalid expiry date!"}), 400

    if len(cvv) != 3 or not cvv.isdigit():
        return jsonify({"success": False, "message": "Invalid CVV!"}), 400

    return jsonify({"success": True, "message": "Payment successful!"})

if __name__ == '__main__':
    app.run(debug=True)
