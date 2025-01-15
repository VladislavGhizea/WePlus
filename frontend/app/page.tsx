import React from "react";
import { Login, LoginThirdPart } from "@/app/components/home";
export default function Home() {
  return (
    <div className="flex justify-center items-center h-screen w-screen">
      <div className="h-[27rem] w-[55.5rem] bg-containerGrey flex justify-between rounded-3xl shadow-2xl">
        <div className="grid grid-cols-2 grid-rows-1 w-full">
          <div className="ml-[2.5rem]">
            <Login />
          </div>
          <LoginThirdPart />
        </div>
      </div>
    </div>
  );
}
