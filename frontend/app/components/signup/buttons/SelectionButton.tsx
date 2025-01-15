"use client";
import React, { useState } from "react";
import { motion } from "motion/react";
interface Props {
  text: string;
  children: React.ReactNode;
  description: string;
}
const SelectionButton: React.FC<Props> = ({ text, children, description }) => {
  const [hover, setHover] = useState(false);
  return (
    <motion.button
      className="w-[22rem] h-[5rem] bg-buttonGrey rounded-full hover:rounded-3xl flex flex-row items-center px-6 relative"
      whileHover={{ height: "18rem" }}
      transition={{
        duration: 0.3,
        ease: "easeInOut",
        type: "spring",
        stiffness: 300,
        damping: 20,
        when: "hover",
      }}
      onHoverStart={() => setHover(true)}
      onHoverEnd={() => setHover(false)}
    >
      {!hover ? (
        <>
          <div className="flex justify-center items-center h-8 w-8">
            {children}
          </div>
          <p className="text-3xl flex-1 justify-center">{text}</p>
        </>
      ) : (
        <div className="flex flex-col justify-center items-center w-full">
          <div className="absolute -top-1/4 h-[8rem] w-[8rem]">{children}</div>
          <p className="text-3xl flex-1 justify-center">{text}</p>
          <p className="text-xl flex-1 justify-center mt-7">{description}</p>
        </div>
      )}
    </motion.button>
  );
};

export default SelectionButton;
