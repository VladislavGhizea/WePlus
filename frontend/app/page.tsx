"use client";
import React from "react";
import { motion, AnimatePresence } from "motion/react";
import { Login, LoginThirdPart } from "@/app/components/home";
{
  //TODO: Convert from class concatenation to library classNames!!!
}
export default function Home() {
  return (
    <AnimatePresence mode="wait">
      <motion.div
        className="flex justify-center items-center h-screen w-screen"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        exit={{ opacity: 0, y: 50, x: -50 }}
        transition={{ duration: 1 }}
      >
        <motion.div
          className="h-[27rem] w-[55.5rem] bg-containerGrey flex justify-between rounded-3xl shadow-2xl"
          initial={{ scale: 0.8 }}
          animate={{ scale: 1 }}
          exit={{ scale: 0.8, y: 50, x: -50 }}
          transition={{ duration: 0.5 }}
        >
          <div className="grid grid-cols-2 grid-rows-1 w-full">
            <div className="ml-[2.5rem]">
              <Login />
            </div>
            <LoginThirdPart />
          </div>
        </motion.div>
      </motion.div>
    </AnimatePresence>
  );
}
