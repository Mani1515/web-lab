document.addEventListener('DOMContentLoaded', () => {
    const showSection = (id) => {
        document.querySelectorAll('.form-container').forEach(section => {
            section.classList.add('hidden');
        });
        document.getElementById(id).classList.remove('hidden');
    };

    const isValidEmail = (email) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    const isValidCardNumber = (number) => /^\d{16}$/.test(number);
    const isValidExpiryDate = (date) => /^(0[1-9]|1[0-2])\/\d{2}$/.test(date);
    const isValidCVV = (cvv) => /^\d{3,4}$/.test(cvv);

    // Registration Form
    document.getElementById('registerForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const name = document.getElementById('regName').value.trim();
        const email = document.getElementById('regEmail').value.trim();
        const password = document.getElementById('regPassword').value;
        const confirmPassword = document.getElementById('regConfirmPassword').value;

        if (!name || !isValidEmail(email) || password.length < 6 || password !== confirmPassword) {
            alert('Please provide valid details for registration.');
            return;
        }
        localStorage.setItem('user', JSON.stringify({ name, email, password }));
        alert('Registration Successful!');
        showSection('login');
    });

    // Login Form
    document.getElementById('loginForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const email = document.getElementById('loginEmail').value.trim();
        const password = document.getElementById('loginPassword').value;

        const user = JSON.parse(localStorage.getItem('user'));
        if (!user || user.email !== email || user.password !== password) {
            alert('Invalid login details!');
            return;
        }
        alert('Login Successful!');
        showSection('profile');
        document.getElementById('profileName').value = user.name;
        document.getElementById('profileEmail').value = user.email;
    });

    // Profile Form
    document.getElementById('profileForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const name = document.getElementById('profileName').value.trim();
        const email = document.getElementById('profileEmail').value;

        const user = { ...JSON.parse(localStorage.getItem('user')), name };
        localStorage.setItem('user', JSON.stringify(user));
        alert('Profile Updated!');
    });

    // Payment Form
    document.getElementById('paymentForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const cardNumber = document.getElementById('cardNumber').value.trim();
        const expiryDate = document.getElementById('expiryDate').value.trim();
        const cvv = document.getElementById('cvv').value.trim();

        if (!isValidCardNumber(cardNumber) || !isValidExpiryDate(expiryDate) || !isValidCVV(cvv)) {
            alert('Invalid payment details!');
            return;
        }
        alert('Payment Successful!');
    });
});
