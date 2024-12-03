document.addEventListener('DOMContentLoaded', () => {
    const showPage = (pageId) => {
        document.querySelectorAll('.page').forEach(page => {
            page.classList.add('hidden');
        });
        document.getElementById(pageId).classList.remove('hidden');
    };

    const isValidEmail = (email) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

    // Registration Form
    document.getElementById('registerForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const name = document.getElementById('regName').value.trim();
        const email = document.getElementById('regEmail').value.trim();
        const password = document.getElementById('regPassword').value;
        const confirmPassword = document.getElementById('regConfirmPassword').value;

        if (!name || !isValidEmail(email) || password.length < 6 || password !== confirmPassword) {
            alert('Invalid registration details.');
            return;
        }
        localStorage.setItem('user', JSON.stringify({ name, email, password }));
        alert('Registration successful!');
        showPage('login');
    });

    // Login Form
    document.getElementById('loginForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const email = document.getElementById('loginEmail').value.trim();
        const password = document.getElementById('loginPassword').value;

        const user = JSON.parse(localStorage.getItem('user'));
        if (!user || user.email !== email || user.password !== password) {
            alert('Invalid login credentials.');
            return;
        }
        alert('Login successful!');
        showPage('transaction');
    });

    // Transaction Form
    document.getElementById('transactionForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const accountNumber = document.getElementById('accountNumber').value.trim();
        const amount = parseFloat(document.getElementById('amount').value);

        if (!/^\d+$/.test(accountNumber) || accountNumber.length < 10 || amount <= 0) {
            alert('Invalid transaction details.');
            return;
        }
        alert(`Transaction of $${amount.toFixed(2)} to account ${accountNumber} successful!`);
    });
});
