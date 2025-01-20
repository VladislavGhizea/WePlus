"use client";
import React from "react";
import { BiHomeAlt2 } from "react-icons/bi";
import { HiOutlineArchiveBox } from "react-icons/hi2";
import { LuMessageSquareMore } from "react-icons/lu";
import { IconButton } from "./buttons";
import { useRouter } from "next/navigation";
const Header = () => {
  const router = useRouter();
  const handleArchiveClick = () => {
    //TODO
  };
  const handleMessageClick = () => {
    //TODO
  };
  const handleHomeClick = () => {
    router.push("/home");
  };

  return (
    <div className="flex justify-between flex-row h-full w-full">
      <IconButton
        icon={<BiHomeAlt2 className="w-[3rem] h-[3rem]" />}
        onClick={handleHomeClick}
      />
      <IconButton
        icon={<HiOutlineArchiveBox className="w-[3rem] h-[3rem]" />}
        onClick={handleArchiveClick}
      />
      <IconButton
        icon={<LuMessageSquareMore className="w-[3rem] h-[3rem]" />}
        onClick={handleMessageClick}
      />
    </div>
  );
};

export default Header;
