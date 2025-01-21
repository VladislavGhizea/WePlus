"use client";
import React from "react";
import {
  HiOutlineArchiveBox,
  HiArrowRightOnRectangle,
  HiOutlineUser,
  HiOutlineHome,
  HiOutlineChatBubbleOvalLeftEllipsis,
} from "react-icons/hi2";
import { IconButton } from "../buttons";
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
  const handleLogoutClick = () => {
    //TODO
  };
  const handleUserClick = () => {
    //TODO
  };

  return (
    <div className="flex justify-between items-center h-[4rem] w-full px-4">
      <IconButton
        icon={<HiArrowRightOnRectangle className="w-[3rem] h-[3rem]" />}
        onClick={handleLogoutClick}
      />
      <div className="flex justify-between flex-row h-[4rem] w-[24rem] bg-darkGrey rounded-full px-4">
        <IconButton
          icon={<HiOutlineHome className="w-[3rem] h-[3rem]" />}
          onClick={handleHomeClick}
        />
        <IconButton
          icon={<HiOutlineArchiveBox className="w-[3rem] h-[3rem]" />}
          onClick={handleArchiveClick}
        />
        <IconButton
          icon={
            <HiOutlineChatBubbleOvalLeftEllipsis className="w-[3rem] h-[3rem]" />
          }
          onClick={handleMessageClick}
        />
      </div>
      <IconButton
        icon={<HiOutlineUser className="w-[3rem] h-[3rem]" />}
        onClick={handleUserClick}
      />
    </div>
  );
};

export default Header;
