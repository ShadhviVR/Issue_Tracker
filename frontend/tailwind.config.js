/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
   "./index.html",
   "./src/**/*.{js,ts,jsx,tsx}",
 ],
 theme: {
   extend: {
     colors: {
       "primary-200" : "#2e9121",
     },
     fontFamily: {
       dmsans: ["DM Sans", "sans-serif"],
       montserrat: ["Montserrat", "sans-serif"],
     },
     boxShadow: {
       myShadow1: "4.1px -5px 0 0 rgb(17,24,39)",
       myShadow2: "-4.1px -5px 0 0 rgb(17,24,39)",
     },
   },
   screens: {
     xs: "480px",
     sm: "768px",
     md: "1060px",
   },
 },
 plugins: [],
};
