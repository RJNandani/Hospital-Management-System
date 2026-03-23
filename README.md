# 🏥 OasisCare Hospital Management System

![OasisCare Banner](https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?q=80&w=1200&h=400&auto=format&fit=crop)

Welcome to **OasisCare**, a robust, wide-screen responsive, full-stack Hospital Management System built from the ground up for medical facilities, doctors, and patients.

✨ **Experience the future of medical portal design with our completely overhauled Patient Dashboard!**  

---

## 🚀 Key Features

### 🌟 1. The Multi-Portal System
- **Landing Page:** A beautiful, responsive hero-image landing page featuring an automatic Doctor Carousel and robust portal routing.
- **Admin Dashboard:** Central command for comprehensive hospital metrics.
- **Doctor Portal:** Dedicated secure environment for specialists to manage their incoming appointments and patient loads.
- **Patient Portal:** Our crown jewel. A fully authenticated, dynamically scaling ecosystem for patients.

### 💼 2. The Patient Experience
- **Fort Knox Security:** No more dropdowns. Patients access their portal via unique ID authentication.
- **Dynamic 90VW Split-Screen Dashboard:** A gorgeous, custom 3-column layout that breaks standard constraints to utilize your full monitor width.
- **Auto-Formatting Medical Histories:** The backend intercepts standard text inputs and dynamically structures them into clean bullet-point lists for instant readability!
- **Chronological Timelines:** Your entire appointment history is rigorously sorted via **FIFO (First-In, First-Out)**—so your oldest appointments sit safely at the top as historical records.

### 🔎 3. Integrated Booking & Smart Search
- **Live Search Engine:** Type a few letters and watch the system instantly filter Doctors by their exact Specialization or Name directly inside the booking form.
- **One-Click Booking:** Found your doctor? Click them in the search box, and they instantly slide into your secure dropdown booking form! Submit it, and the screen automatically flashes and updates your timeline with your brand-new appointment!

---

## 🛠 Tech Stack

**Frontend Framework:**
- **Raw HTML5 & CSS3:** No bloated libraries. Just pure, lightning-fast vanilla code powering complex Flexbox and CSS Grid designs.
- **Vanilla JavaScript:** Highly optimized DOM manipulation, `fetch()` API calls, and dynamic routing.

**Backend Architecture:**
- **Java 17 & Spring Boot:** Enterprise-grade RESTful API endpoints securely bridging the interfaces.
- **H2 Database:** A fully persistent `hospitaldb.mv.db` keeping patient data secure even after the server sleeps.
- **Dynamic Database Seeding:** Smart backend script (`DatabaseSeeder.java`) that auto-populates rich demonstration data!

---

## ⚙️ How to Run & Test (Presentation Mode)

Want to see OasisCare spring to life instantly with full presentation data?

1. **Purge the Old DB:** Open your terminal and navigate to your folder. If you see `hospitaldb.mv.db` inside your backend, **delete it!** This forces our automated seeder to rebuild a fresh copy with multi-appointment timelines!
2. **Boot the Server:** 
   ```bash
   cd backend
   mvn spring-boot:run
   ```
3. **Launch the Portal:** Open `frontend/landing.html` in Chrome, Edge, or Firefox.
4. **Log In Seamlessly:** Click into the Patient Portal and enter **ID: 1** (John Doe) to instantly view all the advanced chronology and bullet-point sorting logic in action!

---

### *Built for the OasisCare Initiative*
