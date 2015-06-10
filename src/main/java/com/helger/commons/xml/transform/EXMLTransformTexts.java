/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.commons.xml.transform;

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.Translatable;
import com.helger.commons.text.MapBasedMultilingualText;
import com.helger.commons.text.display.IHasDisplayText;
import com.helger.commons.text.resolve.DefaultTextResolver;

@Translatable
public enum EXMLTransformTexts implements IHasDisplayText
{
  TRANSFORMATION_WARNING ("Transformationswarnung", "Transformation warning"),
  TRANSFORMATION_ERROR ("Transformationsfehler", "Transformation error"),
  TRANSFORMATION_FATAL_ERROR ("Schwerer Transformationsfehler", "Transformation fatal error");

  private final MapBasedMultilingualText m_aTP;

  private EXMLTransformTexts (@Nonnull final String sDE, @Nonnull final String sEN)
  {
    m_aTP = MapBasedMultilingualText.create_DE_EN (sDE, sEN);
  }

  @Nullable
  public String getDisplayText (@Nonnull final Locale aContentLocale)
  {
    return DefaultTextResolver.getText (this, m_aTP, aContentLocale);
  }
}
