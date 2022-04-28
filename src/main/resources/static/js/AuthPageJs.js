"use strict"


//get language info (solution 1)
// function getClientLocale() {
//     if (typeof Intl !== 'undefined') {
//       try {
//         return Intl.NumberFormat().resolvedOptions().locale;
//       } catch (err) {
//         console.error("Cannot get locale from Intl")
//       }
//     }
//   }

// let lang = getClientLocale()

//get language info (solution 2)
let languageList = window.navigator.languages || window.navigator.language || window.navigator.userLanguage || window.navigator.browserLanguage;
let form = document.getElementById("languagefrom");
document.getElementById("language").value = languageList[0];



