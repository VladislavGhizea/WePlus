"use client";
import React, { useState } from "react";
import { motion, AnimatePresence } from "framer-motion";
import { Signup, Selection } from "@/app/signup/pages";

const Page = () => {
  const [step, setStep] = useState(1);

  const handleNext = () => {
    setStep(step + 1);
  };
  const handleBack = () => {
    setStep(step - 1);
  };

  return (
    <AnimatePresence mode="wait">
      {step === 1 && (
        <motion.div
          key="signup"
          initial={{ opacity: 0, y: 50 }}
          animate={{ opacity: 1, y: 0 }}
          exit={{ opacity: 0, y: -50 }}
          transition={{ duration: 0.5 }}
        >
          <Signup onNext={handleNext} />
        </motion.div>
      )}
      {step === 2 && (
        <motion.div
          key="selection"
          initial={{ opacity: 0, y: 50 }}
          animate={{ opacity: 1, y: 0 }}
          exit={{ opacity: 0, y: -50 }}
          transition={{ duration: 0.5 }}
        >
          <Selection onBack={handleBack} />
        </motion.div>
      )}
    </AnimatePresence>
  );
};

export default Page;
