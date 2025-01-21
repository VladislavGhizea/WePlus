"use client";
import React from "react";
import { Header, Sidebar, Container } from "../components/home/page";
import useBackground from "../hooks/useBackground";

const Page = () => {
  useBackground("#E0E7FF");
  return (
    <div className="h-screen w-screen">
      <header className="flex justify-center mt-2">
        <Header />
      </header>
      <Sidebar />
      {/* <Container /> */}
    </div>
  );
};

export default Page;
