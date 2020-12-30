package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.factory.impl.FigureType;


public class Specification {
    private final FigureType typeOfTheRequiredFigure;
    private final int startOfTheRange;
    private final int endOfTheRange;

    private Specification(FigureType figureType, int startOfTheRange, int endOfTheRange) {
        this.typeOfTheRequiredFigure = figureType;
        this.startOfTheRange = startOfTheRange;
        this.endOfTheRange = endOfTheRange;
    }

    public FigureType getTypeOfTheRequiredFigure() {
        return this.typeOfTheRequiredFigure;
    }

    public int getStartOfTheRange() {
        return startOfTheRange;
    }

    public int getEndOfTheRange() {
        return endOfTheRange;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static class Builder {
        private FigureType typeOfTheRequiredFigure;
        private int startOfTheRange;
        private int endOfTheRange;

        public Builder findFigure(FigureType figureType) {
            this.typeOfTheRequiredFigure = figureType;
            return this;
        }

        public Builder withIdInRange(int startId, int endId) {
            this.startOfTheRange = startId;
            this.endOfTheRange = endId;
            return this;
        }


        public Specification build() {
            return new Specification(this.typeOfTheRequiredFigure,
                    this.startOfTheRange,
                    this.endOfTheRange);
        }
    }
}
