function register() {
    fetch("/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: document.getElementById("username").value,
            password: document.getElementById("password").value,
            role: document.getElementById("role").value
        })
    })
    .then(res => res.json())
    .then(() => {
        document.getElementById("msg").innerText = "Registered Successfully!";
    });
}

function login() {
    fetch("/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: document.getElementById("username").value,
            password: document.getElementById("password").value
        })
    })
    .then(res => res.text())
    .then(token => {
        localStorage.setItem("token", token);
        window.location.href = "/dashboard";
    });
}

function loadAdmin() {
    fetch("/admin/test", {
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        }
    })
    .then(res => res.text())
    .then(data => document.getElementById("data").innerText = data);
}

function loadUser() {
    fetch("/user/test", {
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        }
    })
    .then(res => res.text())
    .then(data => document.getElementById("data").innerText = data);
}

function logout() {
    localStorage.removeItem("token");
    window.location.href = "/login-page";
}

function goAdmin() {
    window.location.href = "/admin.html";
}

function goUser() {
    window.location.href = "/user.html";
}
