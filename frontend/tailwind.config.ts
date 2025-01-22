import type { Config } from "tailwindcss";

export default {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        background: "var(--background)",
        foreground: "var(--foreground)",
        containerGrey: "var(--container-grey)",
        buttonBlue: "var(--button-blue)",
        buttonGrey: "var(--button-grey)",
        textBlue: "var(--text-blue)",
        darkGrey: "var(--dark-grey)",
        backgroundBlue: "var(--background-blue)",
        textGrey: "var(--text-grey)",
        iconGrey: "var(--icon-grey)",
      },
    },
  },
  plugins: [],
} satisfies Config;
