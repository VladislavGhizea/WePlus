"use client";
import React from "react";
import { useRouter } from "next/navigation";
import classNames from "classnames";

interface Props {
  text: string;
  className?: string;
  bgColor?: string;
  linkTo?: string;
  onClick?: (event: React.MouseEvent<HTMLButtonElement>) => void;
  width?: string;
  height?: string;
  rounded?: string; // Aggiungi la proprietà rounded
}

const ActionButton: React.FC<Props> = ({
  text,
  className,
  bgColor,
  linkTo,
  onClick,
  width,
  height,
  rounded, // Aggiungi la proprietà rounded
}) => {
  width = width || "9rem";
  height = height || "3.5rem";
  className = className || "";
  bgColor = bgColor || "bg-white";
  rounded = rounded || "rounded-full"; // Imposta un valore predefinito per rounded
  const router = useRouter();
  const onButtonClick = (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    if (onClick) {
      onClick(e);
    } else {
      router.push(linkTo || "/");
    }
  };

  return (
    <button
      className={classNames(className, "relative")}
      onClick={onButtonClick}
    >
      <div
        className={classNames(`w-[${width}] h-[${height}]`, bgColor, rounded)}
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
