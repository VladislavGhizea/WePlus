import React, { useState, useEffect, useCallback, useMemo } from "react";
import { AnimatePresence } from "motion/react";
import { Fisiche, Giuridiche } from "@/app/variables";
import { Modal, Backdrop } from "./sections/fullSnippet";

interface Props {
  width: string;
  height: string;
  parentImage: React.ReactNode;
  visible: boolean;
  onClose: () => void;
  parentText: string;
}

const FullSignUpSnippet: React.FC<Props> = ({
  width,
  height,
  parentImage,
  visible,
  onClose,
  parentText,
}) => {
  const [wizardStep, setWizardStep] = useState(0);
  const [isVisible, setIsVisible] = useState(visible);

  const distanceTop = useMemo(() => `calc((100vh - ${height}) / 2)`, [height]);
  const distanceLeft = useMemo(() => `calc((100vw - ${width}) / 2)`, [width]);

  const [values, setValues] = useState<
    { text: string; type: string; options?: string[] }[]
  >([]);

  useEffect(() => {
    setIsVisible(visible);
  }, [visible]);

  useEffect(() => {
    if (parentText?.toLowerCase() === "persone fisiche") {
      setValues(Fisiche);
    } else if (parentText?.toLowerCase() === "persone giuridiche") {
      setValues(Giuridiche);
    } else {
      setWizardStep(0);
      setValues(Fisiche);
    }
  }, [parentText]);

  const handleClose = useCallback(() => {
    setIsVisible(false);
    onClose();
  }, [onClose]);

  const handleNext = useCallback(() => {
    if (parentText?.toLowerCase() === "entità individuali") {
      if (wizardStep === 0) {
        setWizardStep(1);
        setValues(Giuridiche.filter((value) => value.text !== "Tipo Società"));
      } else {
        handleClose();
        setWizardStep(0);
      }
    } else {
      handleClose();
    }
  }, [handleClose, parentText, wizardStep]);

  const handlePrev = useCallback(() => {
    if (parentText?.toLowerCase() === "entità individuali") {
      if (wizardStep === 1) {
        setWizardStep(0);
        setValues(Fisiche);
      }
    } else {
      handleClose();
    }
  }, [handleClose, parentText, wizardStep]);

  return (
    <AnimatePresence>
      {isVisible && (
        <>
          <Backdrop onClose={handleClose} />
          <Modal
            width={width}
            height={height}
            distanceTop={distanceTop}
            distanceLeft={distanceLeft}
            parentImage={parentImage}
            parentText={parentText}
            values={values}
            handleNext={handleNext}
            handlePrev={handlePrev}
          />
        </>
      )}
    </AnimatePresence>
  );
};

export default FullSignUpSnippet;
