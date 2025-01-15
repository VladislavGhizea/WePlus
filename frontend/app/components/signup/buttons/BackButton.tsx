"use client";
import React from "react";
import { IoIosArrowBack } from "react-icons/io";
import { useRouter } from "next/navigation";
interface Props {
  backTo?: string;
  onClick?: () => void;
}
const BackButton: React.FC<Props> = ({ backTo, onClick }) => {
  const router = useRouter();
  const onButtonClick = (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    if (onClick) {
      onClick();
    } else {
      router.push(backTo || "/");
    }
  };
  return (
    <button onClick={onButtonClick}>
      <div className="h-16 w-16  rounded-full flex justify-center items-center border-[3px] bg-white border-black">
        <IoIosArrowBack className="h-12 w-12" />
      </div>
    </button>
  );
};

export default BackButton;
