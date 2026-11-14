# 📱 Android Application Development Practicals

**Subject Code:** 055004  
**Technology Stack:** Android Studio • Java • XML Views • Gradle  

This repository contains ready-to-build source code and automated CI/CD workflows for **Practicals 3 to 10** from the Android Application Development practical syllabus.

---

## ⚡ Direct Download APKs

Every time code is pushed to this repository, a GitHub Actions workflow automatically builds separate `.apk` files for each practical experiment.

👉 **[Go to GitHub Releases to Download All APKs](https://github.com/onebotyt/android-practical/releases/tag/v1.0.0)**

| Practical | Title | Direct Download Link | Description |
|:---:|:---|:---:|:---|
| **Practical 03** | Simple Calculator | [Download APK](https://github.com/onebotyt/android-practical/releases/download/v1.0.0/Practical-03-Calculator.apk) | Addition, subtraction, multiplication, and division with error checks. |
| **Practical 04** | Menus & Navigation | [Download APK](https://github.com/onebotyt/android-practical/releases/download/v1.0.0/Practical-04-MenuNavigation.apk) | Options Menu and screen switching via explicit `Intent`. |
| **Practical 05** | Internal Storage | [Download APK](https://github.com/onebotyt/android-practical/releases/download/v1.0.0/Practical-05-InternalStorage.apk) | File writing (`openFileOutput`) and reading (`openFileInput`) in private storage. |
| **Practical 06** | SQLite To-Do List | [Download APK](https://github.com/onebotyt/android-practical/releases/download/v1.0.0/Practical-06-SqliteTodoList.apk) | SQLite database CRUD (`INSERT`, `SELECT`, `DELETE` on long-click). |
| **Practical 07** | Send Email Intent | [Download APK](https://github.com/onebotyt/android-practical/releases/download/v1.0.0/Practical-07-EmailIntent.apk) | Implicit `Intent` with `ACTION_SENDTO` to delegate email composition. |
| **Practical 08** | Graphics & Animation | [Download APK](https://github.com/onebotyt/android-practical/releases/download/v1.0.0/Practical-08-Animation.apk) | Rotating ImageView animation using `RotateAnimation`. |
| **Practical 09** | Google Maps & Location | [Download APK](https://github.com/onebotyt/android-practical/releases/download/v1.0.0/Practical-09-GoogleMaps.apk) | Google Maps SDK Fragment with runtime location indicator. |
| **Practical 10** | Device Camera | [Download APK](https://github.com/onebotyt/android-practical/releases/download/v1.0.0/Practical-10-Camera.apk) | `ACTION_IMAGE_CAPTURE` intent and thumbnail preview via Activity Result. |

*(Note: Practicals 1 & 2 are installation and IDE-study experiments which do not require code/APKs).*

---

## 📂 Repository Structure

The project is structured as an Android Multi-Module Gradle workspace:

```text
android-practical/
├── .github/
│   └── workflows/
│       └── build-apks.yml           # Automated CI/CD pipeline to compile all APKs
├── practical03_calculator/          # Practical 3: Simple Calculator
├── practical04_menuapp/             # Practical 4: Menus & Screen Navigation
├── practical05_storageapp/          # Practical 5: Internal Storage
├── practical06_todoapp/             # Practical 6: SQLite To-Do List
├── practical07_emailapp/            # Practical 7: Sending Email via Intent
├── practical08_animationapp/        # Practical 8: Graphics and Animation
├── practical09_locationapp/         # Practical 9: Location & Google Maps
├── practical10_cameraapp/           # Practical 10: Camera Intent & Photo Capture
├── settings.gradle                  # Subproject module declarations
├── build.gradle                     # Top-level Gradle configuration
└── gradle.properties                # Build environment optimizations
```

---

## 📖 Practical Details & Record Book Write-ups

### Practical 3: Simple Calculator
- **Aim:** To develop a simple calculator that performs addition, subtraction, multiplication, and division.
- **Key Concepts:** `EditText`, `Button`, `TextView`, Event Listeners, input parsing, zero-division error handling.
- **Package:** `com.example.calculator`

### Practical 4: Menus and Screen Navigation
- **Aim:** To create an Android application that displays an options menu and navigates between screens.
- **Key Concepts:** `onCreateOptionsMenu`, `onOptionsItemSelected`, `res/menu/main_menu.xml`, explicit `Intent`, `SecondActivity`.
- **Package:** `com.example.menuapp`

### Practical 5: Internal Storage
- **Aim:** To store and retrieve private data using the device's internal storage.
- **Key Concepts:** `openFileOutput(MODE_PRIVATE)`, `openFileInput`, `Toast`, internal sandbox storage security.
- **Package:** `com.example.storageapp`

### Practical 6: SQLite To-Do List
- **Aim:** To create a simple to-do list application using SQLite database.
- **Key Concepts:** `SQLiteDatabase`, `execSQL`, `rawQuery`, `Cursor`, `ArrayAdapter`, `ListView.setOnItemLongClickListener`.
- **Package:** `com.example.todoapp`

### Practical 7: Internet Connection and Sending Email
- **Aim:** To connect an Android application with an email application and prepare an email.
- **Key Concepts:** Implicit Intent (`Intent.ACTION_SENDTO`), URI scheme `mailto:`, Intent Chooser (`Intent.createChooser`).
- **Package:** `com.example.emailapp`

### Practical 8: Graphics and Animations
- **Aim:** To display a graphic and apply rotation animation in an Android application.
- **Key Concepts:** `ImageView`, `RotateAnimation`, `Animation.RELATIVE_TO_SELF`, duration and repeat count controls.
- **Package:** `com.example.animationapp`

### Practical 9: Location-Based Services with Google Maps
- **Aim:** To display Google Maps and enable the user's current-location indicator.
- **Key Concepts:** `SupportMapFragment`, `GoogleMap`, `OnMapReadyCallback`, runtime permissions (`ACCESS_FINE_LOCATION`).
- **Package:** `com.example.locationapp`

### Practical 10: Device Camera
- **Aim:** To capture a photograph using the device camera and display it in an ImageView.
- **Key Concepts:** `ActivityResultLauncher`, `ActivityResultContracts.StartActivityForResult()`, `MediaStore.ACTION_IMAGE_CAPTURE`, Bitmap thumbnails.
- **Package:** `com.example.cameraapp`

---

## 📸 How to Take Screenshots for Your Lab Book

1. Visit the **Releases** tab on GitHub using your phone's browser.
2. Tap each `.apk` file to download and install.
3. Open each app, perform its action (e.g., calculate numbers, open menu, write file, add to-do task, rotate compass, take photo).
4. Take a screenshot (Power + Volume Down) and insert the screenshot into your lab report under the respective practical.
