"use client";
import React from "react";
import {
  Header,
  Sidebar,
  ContainerCreator,
  Filters,
} from "../components/home/page";
import useBackground from "../hooks/useBackground";
interface Filter {
  name: string;
  onSubmit: () => void;
}
const Page = () => {
  const filters: Filter[] = [
    {
      name: "Filtro1",
      onSubmit: () => {
        console.log("Filtro1 submit");
      },
    },
    {
      name: "Filtro2",
      onSubmit: () => {
        console.log("Filtro2 submit");
      },
    },
  ];

  useBackground("#E0E7FF");
  return (
    <div className="h-screen w-screen">
      <header className="flex justify-center mt-3">
        <Header />
      </header>
      <div className="flex flex-row h-full w-full">
        <Sidebar />
        <div className="flex flex-col h-full w-full">
          <Filters filters={filters} />
          <ContainerCreator />
        </div>
      </div>
    </div>
  );
};

export default Page;
