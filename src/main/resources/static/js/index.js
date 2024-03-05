document.querySelectorAll('.icon').forEach(function (icon) {
    icon.addEventListener('click', function () {
        // Toggle 'active' class
        icon.classList.toggle('active');
    });
});