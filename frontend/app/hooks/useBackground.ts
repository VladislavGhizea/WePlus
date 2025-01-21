"use client";
import { useEffect } from "react";

const useBackground = (color: string) => {
  useEffect(() => {
    document.documentElement.style.setProperty("--background", color);
  }, [color]);
};

export default useBackground;
