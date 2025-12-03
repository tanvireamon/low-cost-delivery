// === Navbar Dropdown Hover for Desktop ===
document.querySelectorAll('.navbar .dropdown').forEach(function(dropdown){
  dropdown.addEventListener('mouseenter', function(){
    if(window.innerWidth > 992) {
      let toggle = dropdown.querySelector('.dropdown-toggle');
      let menu = dropdown.querySelector('.dropdown-menu');
      menu.classList.add('show');
      toggle.setAttribute('aria-expanded', 'true');
    }
  });

  dropdown.addEventListener('mouseleave', function(){
    if(window.innerWidth > 992) {
      let toggle = dropdown.querySelector('.dropdown-toggle');
      let menu = dropdown.querySelector('.dropdown-menu');
      menu.classList.remove('show');
      toggle.setAttribute('aria-expanded', 'false');
    }
  });
});

// === Contact Form Validation ===
const form = document.querySelector('.contact-us-single form');

form.addEventListener('submit', function(e) {
  e.preventDefault();

  const name = form.querySelector('input[type="text"]');
  const email = form.querySelector('input[type="email"]');
  const mobile = form.querySelector('input[type="tel"]');
  const message = form.querySelector('textarea');

  if(!name.value.trim() || !email.value.trim() || !mobile.value.trim() || !message.value.trim()) {
    alert("Please fill all fields before submitting!");
    return false;
  }

  alert("Message sent successfully!");
  form.reset();
});

// === Carousel Auto Play ===
const carouselElement = document.querySelector('#heroCarousel');
const carousel = new bootstrap.Carousel(carouselElement, {
  interval: 4000,
  ride: 'carousel',
  pause: 'hover'
});
