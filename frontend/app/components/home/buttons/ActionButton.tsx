"use client";
import React from "react";
import { useRouter } from "next/navigation";
interface Props {
  text: string;
  className?: string;
  bgColor?: string;
  linkTo?: string;
  onClick?: () => void;
}
const ActionButton: React.FC<Props> = ({
  text,
  className,
  bgColor,
  linkTo,
  onClick,
}) => {
  className = className || "";
  bgColor = bgColor || "bg-white";
  const router = useRouter();
  const onButtonClick = (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    if (onClick) {
      onClick();
    } else {
      router.push(linkTo || "/");
    }
  };
  return (
    <button className={className + " relative"} onClick={onButtonClick}>
      <div className={"w-[9rem] h-[3.5rem] rounded-full " + bgColor}>
        <div className="flex justify-center items-center h-full text-2xl">
          {text}
        </div>
      </div>
    </button>
  );
};
export default ActionButton;
