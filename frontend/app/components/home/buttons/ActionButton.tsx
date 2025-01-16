"use client";
import React from "react";
import { useRouter } from "next/navigation";
interface Props {
  text: string;
  className?: string;
  bgColor?: string;
  linkTo?: string;
  onClick?: () => void;
  width?: string;
  height?: string;
}
const ActionButton: React.FC<Props> = ({
  text,
  className,
  bgColor,
  linkTo,
  onClick,
  width,
  height,
}) => {
  width = width || "9rem";
  height = height || "3.5rem";
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
      <div
        className={`w-[${width}] h-[${height}] rounded-full ${bgColor}`}
        style={{ width, height }}
      >
        <div className="flex justify-center items-center h-full text-2xl">
          {text}
        </div>
      </div>
    </button>
  );
};
export default ActionButton;
