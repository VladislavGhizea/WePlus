"use client";
import React from "react";
import { IconTextButton } from "../buttons";
import { HiCog6Tooth, HiOutlineStar } from "react-icons/hi2";
import { Category } from "./";
const Sidebar = () => {
  const handleSettingsClick = () => {
    //TODO
  };
  const handleStarredClick = () => {
    //TODO
  };
  return (
    <>
      <div className="flex flex-row h-full">
        <div className="flex flex-col items-center w-[16rem] h-full px-5">
          <IconTextButton
            icon={<HiCog6Tooth className="w-6 h-6" />}
            onClick={handleSettingsClick}
            text={"Impostazioni"}
            className=" bg-darkGrey"
          />
          <div className="h-[1px] w-full bg-textGrey mt-5 rounded-full" />
          <Category
            icon={<HiOutlineStar className="w-5 h-5" />}
            text={"Preferiti"}
            onClick={handleStarredClick}
          ></Category>
        </div>
        <div className="my-10">
          <div className="h-full w-[1px] bg-textGrey rounded-full" />
        </div>
      </div>
    </>
  );
};

export default Sidebar;
